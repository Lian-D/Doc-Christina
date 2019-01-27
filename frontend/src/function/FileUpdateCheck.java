package function;

import java.io.File;

public class FileUpdateCheck {
    private long timeStamp;
    private File file;

    public boolean isFileUpdated( File file ) {
        this.file = file;
        this.timeStamp = file.lastModified();

        if( this.timeStamp != timeStamp ) {
            this.timeStamp = timeStamp;
            //Yes, file is updated
            return true;
        }
        //No, file is not updated
        return false;
    }
}
