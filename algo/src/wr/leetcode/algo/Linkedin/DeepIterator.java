package wr.leetcode.algo.Linkedin;

import java.util.*;

class Data {
    Integer data = null;
    List<Data> dataCollection;

    boolean isCollection() {
        return (null == data);
    }

    Collection<Data> getCollection() {
        return dataCollection;
    }

    Integer getElement() {
        return data;
    }

    public Data(Integer data) {
        this.data = data;
    }

    public Data(Data... datas) {
        dataCollection = Arrays.asList(datas);
    }

}

public class DeepIterator implements Iterator<Data> {

    Stack<Iterator<Data>> st = new Stack<>();
    /**
     * It's better to use next value here as we cannot put both Data and DataIterator in the stack.
     * OtherOptions:
     *  1. we will be fallback similar to array: warp index and data in another class used by stack
     *  2. wrap iterator and data in a class similar as Data to indicate if it is value or iterator
     *
     *  But in general, only top of the stack is data, otherwise it's all arrays.
     *
     */
    Data next = null;

    public DeepIterator( Data data ) {
        if (data.isCollection()) {
            st.push(data.getCollection().iterator());
        } else {
            next = data;
        }
        advance();
    }

    private void advance() {
        while(next == null && !st.isEmpty()) {
            Iterator<Data> iterator = st.peek();
            if (iterator.hasNext()) {
                Data nextData = iterator.next();
                if (nextData.isCollection()) {
                    st.push(nextData.getCollection().iterator());
                } else {
                    next = nextData;
                }
            } else {
                st.pop();
            }
        }
    }

    @Override
    public boolean hasNext() {
        //BUG: WATCH OUT FOR ADVANCE!
        advance();
        return (null != next);
    }

    @Override
    public Data next() {
        //BUG: WATCH OUT FOR reset NULL!
        if(!hasNext()) {
            throw new IllegalStateException("No more elements!");
        }
        Data ret = next;
        next = null;
        return ret;
    }

    public static void main(String[] args) {
        Data [] datas = {
                new Data(1),
                new Data(),
                new Data( new Data(), new Data(),new Data(new Data(),new Data()), new Data()),
                new Data( new Data( new Data(1), new Data(2)), new Data(3), new Data(new Data(4), new Data(), new Data( new Data(5), new Data(6))))
        };

        for (Data data : datas) {
            DeepIterator iterator = new DeepIterator(data);
            while(iterator.hasNext()) {
                System.out.println(iterator.next().getElement());
            }
            System.out.println("------");
        }
    }
}