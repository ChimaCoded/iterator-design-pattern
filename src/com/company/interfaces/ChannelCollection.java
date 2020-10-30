package com.company.interfaces;

import com.company.classes.Channel;
import com.company.enumerator.ChannelTypeEnum;

public interface ChannelCollection {
//      method for subscribing to a channel
    public void addChannel(Channel c);
//      method for unsubscribing to a channel
    public void removeChannel(Channel c);
//      method for iterating over channels, giving an identifier.
    public ChannelIterator iterator(ChannelTypeEnum type);
}