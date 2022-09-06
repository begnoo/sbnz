package domb.app.services;

import domb.app.dto.TemplateDTO;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.tools.ant.types.Commandline;
import org.springframework.stereotype.Service;
import org.kie.api.runtime.KieSession;
import org.drools.template.ObjectDataCompiler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static jdk.jfr.internal.SecuritySupport.getResourceAsStream;


@Service
public class TemplateService {

    private final KieSession kieSession;

    public TemplateService(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    public boolean createNewRule(TemplateDTO templateDTO) {
        InputStream template = TemplateService.class.getResourceAsStream("/template.drt");
        List<TemplateDTO> data = new ArrayList<>();
        if(template != null) {
            System.out.println(template + " ");
        }
        data.add(templateDTO);

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);

        drl = drl.substring(drl.indexOf("rule"));

        try {
            Files.write(Paths.get("../rules/src/main/resources/templateRules.drl"), drl.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        recompileKjar();
        return true;
    }

    public void recompileKjar() {
        String cmd = "../build-template.bat";
        CommandLine cmdLine = CommandLine.parse(cmd);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(0);

        try {
            executor.execute(cmdLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
