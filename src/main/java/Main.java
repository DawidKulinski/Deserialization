import java.io.File;

import org.apache.catalina.Context;
//import org.apache.catalina.WebResourceRoot;
//import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
//import org.apache.catalina.webresources.DirResourceSet;
//import org.apache.catalina.webresources.StandardRoot;
import org.apache.naming.resources.VirtualDirContext;
import org.apache.tomcat.util.scan.StandardJarScanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context ctx = tomcat.addWebapp(tomcat.getHost(), "/", new File(webappDirLocation).getAbsolutePath());
        ((StandardJarScanner) ctx.getJarScanner()).setScanAllDirectories(true);

        System.out.println("Configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        File additionWebInfClasses = new File("target/classes");
        VirtualDirContext resources = new VirtualDirContext();
        resources.setExtraResourcePaths("/WEB-INF/classes=" + additionWebInfClasses);
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
