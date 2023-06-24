package sample;

import java.util.ArrayList;

public class Sort<T>
    {
    private ArrayList<T> items;

    public Sort(ArrayList items)
        {
        this.items = items;
        }

    public ArrayList getItems()
        {
        return items;
        }

    public void setItems(ArrayList items)
        {
        this.items = items;
        }

    public void sort(Comparator comparator)
        {
        T temp;
        for(int i=0;i<items.size();i++)
            {
            for (int j=i+1;j<items.size();j++)
                {
                if (comparator.compare(items.get(i), items.get(j)))
                    {
                    temp = items.get(i);
                    items.set(i,items.get(j));
                    items.set(j,temp);
                    }
                }
            }
        }
    }
