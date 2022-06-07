package domb.app.model.enums;

public enum PartEnum {
    NONE, UNKNOWN, 
    
    // ODB
    PCV, RESET_OBD, SPARK_PLUGS, FUEL_TANK, VAPOR_SENSOR,
    CATALYZER, FUEL_PUMP, PCV_LEAK, MAF,
    
    //USER INPUT
    ENGINE_LUBRICATION, ADD_OIL, LOOSE_VALVE, DRIVE_BELT, BREAK_PADS,

    //MAJOR
    MAJOR_ENGINE_LUBRICATION, MAJOR_DRIVE_BELT,

    //WARNING
    ENGINE_WARNING
}
