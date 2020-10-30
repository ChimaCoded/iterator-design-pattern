package com.company.classes;

import com.company.enumerator.ChannelTypeEnum;

public class Channel {
//      class members
    private final double frequency;
    private final ChannelTypeEnum TYPE;

//      constructor
    public Channel(double freq, ChannelTypeEnum type){
        this.frequency=freq;
        this.TYPE=type;
    }

//      accessors
    public double getFrequency() {
        return frequency;
    }

    public ChannelTypeEnum getTYPE() {
        return TYPE;
    }

    @Override
    public String toString(){
        return "Channel Frequency: " + this.frequency + ", Type: "+this.TYPE;
    }

}