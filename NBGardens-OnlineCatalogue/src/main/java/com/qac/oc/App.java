package com.qac.oc;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This class is used ins SOA to specify the root for web service uri's
 * 
 * @author James Thompson
 */
@ApplicationPath(value="/ocapi")
public class App extends Application { }