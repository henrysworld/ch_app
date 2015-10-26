package com.ch.ch_library.eventbus;

/**
 * Created by chenhe on 2015/10/22.
 */
public class EventCenter<T> {

    /**
     * reserved data
     * by:chenhe at:2015/10/22
     */
    private T data;

    /**
     * this code distinguish between different event
     * by:chenhe at:2015/10/22
     */
    private int eventCode = -1;


    public EventCenter(int eventCode){
        this(eventCode, null);
    }

    public EventCenter(int eventCode, T data){
        this.eventCode = eventCode;
        this.data = data;
    }

    /**
     * get event code
     * by:chenhe at:2015/10/22
     *
     * @return
     */
    public int getEventCode(){
        return this.eventCode;
    }

    /**
     * get data
     * by:chenhe at:2015/10/22
     *
     * @return
     */
    public T getData(){
        return this.data;
    }
}
