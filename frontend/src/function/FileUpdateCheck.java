package function;

import java.io.File;

public class FileUpdateCheck {
    public long timeStamp;
    private File file;

    public void fileUpdate( File file ) {
        this.file = file;
        this.timeStamp = file.lastModified();
    }

    public boolean isFileUpdated( File file ) {
        Long timeStamp = file.lastModified();

        if( this.timeStamp != timeStamp ) {
            this.timeStamp = timeStamp;
            //Yes, file is updated
            return true;
        }
        //No, file is not updated
        return false;
    }
}
