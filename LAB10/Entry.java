package LAB10;

import java.util.Arrays;

public class Entry <T>{
    private T dataObject;
    private String status;



    public void setDataObject(T dataObject) {
        this.dataObject = dataObject;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public T getDataObject() {
        return dataObject;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "["+dataObject+", '"+status+"']";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

