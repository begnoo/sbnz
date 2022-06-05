import { Container } from "@chakra-ui/react";
import NavBar from "./NavBar";

export default function SiteLayout({children}) {

    return (
        <>
            <NavBar  as={"header"} position={"fixed"} w={"100%"}/>
            <Container as={"main"} maxWidth="100vh">
                {children}
            </Container>
        </>
    );

}