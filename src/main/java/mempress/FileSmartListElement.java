package mempress;

import com.google.common.base.Preconditions;

import java.io.File;

/**
 * Created by bartek on 2014-11-13.
 */
public class FileSmartListElement<E> extends SmartListElement<E> {
    protected File storedData;
    protected Class<E> objectType;


    public FileSmartListElement(long chck, File tmpFile, Class<E> obType) {
        super(chck);
        Preconditions.checkNotNull(tmpFile);
        Preconditions.checkNotNull(obType);

        storedData = tmpFile;
        objectType = obType;
    }

    @Override
    public E getObject() {
        Object des = Serializer.desf(storedData);
        E et = objectType.cast(des);

        return et;
    }
}
