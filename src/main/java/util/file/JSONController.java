package util.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.Feature;

import java.util.List;

/**
 *  Utility class {@code JSONController}
 *
 *  The JSONController class provides some simple methods for JSON input or output.
 *
 *  <p>The JSONController class provides some simple methods for JSON input or output.
 *  The most important feature of this class is that it can allow any class to be
 *  saved in the JSON file
 *
 *  @author  Chenyang He
 *  @version 1.0
 */
public class JSONController {
    private final IOController io;

    /** Constructor of CSVController
     * @param filename the name of the CSV file which needs to be I/O.
     */
    public JSONController(String filename) {
        io=new IOController(filename);
        int features = 0;
        features |= Feature.AutoCloseSource.getMask();
        features |= Feature.InternFieldNames.getMask();
        features |= Feature.AllowUnQuotedFieldNames.getMask();
        features |= Feature.AllowSingleQuotes.getMask();
        features |= Feature.AllowArbitraryCommas.getMask();
        features |= Feature.SortFeidFastMatch.getMask();
        features |= Feature.IgnoreNotMatch.getMask();
        JSON.DEFAULT_PARSER_FEATURE = features;
    }

    /**
     * read an array of objects from the JSON file
     * @param tClass the class information of the objects in the file
     * @param <T> Any javabean object
     * @return the array contains the objects which are read from the file
     */
    public <T> List<T> readArray(Class<T> tClass) {
        String json=io.directRead();
        return JSONArray.parseArray(json,tClass);
    }

    /**
     * write an array of objects to the JSON file
     * @param objectList the List contains the objects which will be written to the file
     * @return Whether the write operation was successful
     */
    public boolean writeArray(List<?> objectList) {
        String temp= JSON.toJSONString(objectList);
        return io.directWrite(temp);
    }
}