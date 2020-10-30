package com.company.classes;
import com.company.enumerator.ChannelTypeEnum;
import com.company.interfaces.ChannelCollection;
import com.company.interfaces.ChannelIterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {
//      data structure for holding a collection of channels.
    private final List<Channel> channelsList;
//      class constructor
    public ChannelCollectionImpl() {
        channelsList = new ArrayList<>();
    }
//      implementation of the addChannel method
    public void addChannel(Channel c) {
        this.channelsList.add(c);
    }
//      implementation of the removeChannel method
    public void removeChannel(Channel c) {
        this.channelsList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type) {
        return new ChannelIteratorImpl(type, this.channelsList);
    }

//    creation of
//    static (implementation is exclusive to the class, not to a particular object)
//    inner class.
    private static class ChannelIteratorImpl implements ChannelIterator {
//          member variables
        private final ChannelTypeEnum type;
        private final List<Channel> channels;
        private int position;

//          class constructor
        public ChannelIteratorImpl(ChannelTypeEnum ty, List<Channel> channelsList) {
            this.type = ty;
            this.channels = channelsList;
        }

        @Override
        public boolean hasNext() {
            while (position < channels.size()) {
                Channel c = channels.get(position);
                if (c.getTYPE().equals(type) || type.equals(ChannelTypeEnum.ALL)) {
                    return true;
                } else
                    position++;
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel c = channels.get(position);
            position++;
            return c;
        }

    }
}