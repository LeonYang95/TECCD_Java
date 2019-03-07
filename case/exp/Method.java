public class Method{
    public void execute() throws BuildException {
/**  A server name is required to continue */
        if (server == null) {
            throw new BuildException("No Server Specified");
        }
/**  A userid and password must appear together
 *   if they appear.  They are not required.
 */
        if (userid == null && password != null) {
            throw new BuildException("No Userid Specified");
        }
        if (password == null && userid != null) {
            throw new BuildException("No Password Specified");
        }

/**  Create the telnet client object */
        AntTelnetClient telnet = null;
        boolean success = false;
        try {
            telnet = new AntTelnetClient();
            try {
                telnet.connect(server, port);
            } catch (IOException e) {
                throw new BuildException("Can't connect to " + server);
            }
/**  Login if userid and password were specified */
            if (userid != null && password != null) { //NOSONAR
                login(telnet);
            }
/**  Process each sub command */
            Enumeration tasksToRun = telnetTasks.elements();
            while (tasksToRun != null && tasksToRun.hasMoreElements()) {
                TelnetSubTask task = (TelnetSubTask) tasksToRun.nextElement();
                if (task instanceof TelnetRead && defaultTimeout != null) {
                    ((TelnetRead) task).setDefaultTimeout(defaultTimeout);
                }
                task.execute(telnet);
            }
            success = true;
        } finally {
            if (telnet != null && telnet.isConnected()) {
                try {
                    telnet.disconnect();
                } catch (IOException e) {
                    String msg = "Error disconnecting from " + server;
                    if (success) {
                        throw new BuildException(msg); //NOSONAR
                    } else { // don't hide inner exception
                        log(msg, Project.MSG_ERR);
                    }
                }
            }
        }
    }


}