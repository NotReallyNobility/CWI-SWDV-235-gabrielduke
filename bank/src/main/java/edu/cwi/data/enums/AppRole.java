package edu.cwi.data.enums;
import io.javalin.security.RouteRole;

public enum AppRole implements RouteRole { 
    NONE, 
    CUSTOMER, 
    ADMIN 
}