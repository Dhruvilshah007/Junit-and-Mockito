package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalTest {

    @Test
    @Disabled("Don't run until JIRA #123 is resolved")
    void basicTest(){
        //execute method and perform assertitions
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly(){
        //This test will only execute if on Microsoft OS
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly(){
        //This test will only execute if on Mac OS
    }

    @Test
    @EnabledOnOs({OS.WINDOWS,OS.MAC})
    void testForMacAndWindowsOnly(){
        //This test will only execute if on Microsoft(windows) and Mac OS
    }


    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly(){
        //This test will only execute if on Linux OS
    }


    //Java version
    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForOnlyJava17(){
        //This test will only execute if Java version is 17
    }

    @Test
    @EnabledOnJre(JRE.JAVA_13)
    void testForOnlyJava13(){
        //This test will only execute if Java version is 13
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_13,max = JRE.JAVA_17)
    void testForGivenRange(){
        //This test will only execute if Java version is between 13 to 18(inclusive both 13 and 18).
    }



    @Test
    @EnabledForJreRange(min = JRE.JAVA_13)
    void testForMinJava(){
        //This test will only execute if Java version is greater equal than 13
    }


    //System variable


    @Test
    @EnabledIfEnvironmentVariable(named = "LUV2CODE_ENV",matches = "DEV")
    void testOnlyForDevEnvironment(){
        //This test will only execute if DEV environment is there
        //In Edit run configuration add foll. in env variable to test(for this conditional class only)
        //LUV2CODE_ENV=DEV
    }

    @Test
    @EnabledIfSystemProperty(named = "LUV2CODE_SYS_PROP",matches = "CI_CD_DEPLOY")
    void testOnlyForSystemProperty(){
        //This test will only execute if LUV2CODE_SYS_PROP system property is there
        //In Edit run configuration add foll. in vm options to test(for this conditional class only)
        //-DLUV2CODE_SYS_PROP=CI_CD_DEPLOY
    }




}