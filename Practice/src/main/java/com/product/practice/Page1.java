package com.product.practice;

import com.google.common.collect.Lists;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import java.util.List;

/**
 * Created by Kamlesh on 2015-07-21.
 */
public class Page1 extends WebPage {

    private List<String> sortColumns= Lists.newArrayList();
    private ListView<String> sortColumnRows;

    public Page1(){

        for(int i=2;i<10;i++){
            sortColumns.add("Field"+i);
        }
        sortColumns.add("Field1");
        sortColumnRows=new ListView<String>("sortColumnRows",sortColumns) {
            @Override
            protected void populateItem(ListItem<String> item) {
                final String cell=item.getModelObject();
                final Label label=new Label("label",cell);
                item.add(label);
            }
        };
        sortColumnRows.setOutputMarkupId(true);
        add(sortColumnRows);


    }

}
