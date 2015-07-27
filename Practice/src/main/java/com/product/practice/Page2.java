package com.product.practice;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;

/**
 * Created by Kamlesh on 2015-07-26.
 */
public class Page2 extends WebPage {

    Boolean isGeoVisible=true;
    Boolean isPropTypesVisible=false;
    Boolean isContactsVisible=true;
    Boolean isOwnerShipVisible=true;
    Boolean isCountyVisible=true;

    public Page2(){
        Label h5=new Label("h5","OtherGeoGraphic");
        add(h5);

        Label c5=new Label("c5","Geo Locations");
        add(c5);

        Label h6=new Label("h6","PropTypes");
        add(h6);

        Label c6=new Label("c6","Property Types");
        add(c6);

        Label h7=new Label("h7","Contacts");
        add(h7);

        Label c7=new Label("c7","Contacts Info");
        add(c7);

        Label h8=new Label("h8","OwnershipStatus");
        add(h8);

        Label c8=new Label("c8","Ownership Status");
        add(c8);

        WebMarkupContainer geoC=new WebMarkupContainer("geoC");
        geoC.setOutputMarkupId(true);
        add(geoC);
        Label h9=new Label("h9","Header 9");
        geoC.add(h9);
        Label c9=new Label("c9","Content 9");
        geoC.add(c9);
        add(geoC);


        WebMarkupContainer proptypeC=new WebMarkupContainer("proptypeC");
        proptypeC.setOutputMarkupId(true);
        add(proptypeC);
        Label h10=new Label("h10","Header 10");
        proptypeC.add(h10);
        Label c10=new Label("c10","Content 10");
        proptypeC.add(c10);
        add(proptypeC);

        WebMarkupContainer contactC=new WebMarkupContainer("contactC");
        contactC.setOutputMarkupId(true);
        add(contactC);
        Label h11=new Label("h11","Header 11");
        contactC.add(h11);
        Label c11=new Label("c11","Content 11");
        contactC.add(c11);
        add(contactC);

        WebMarkupContainer ownershipC=new WebMarkupContainer("ownershipC");
        ownershipC.setOutputMarkupId(true);
        add(ownershipC);
        Label h12=new Label("h12","Header 12");
        ownershipC.add(h12);
        Label c12=new Label("c12","Content 12");
        ownershipC.add(c12);
        add(ownershipC);

        WebMarkupContainer contyC=new WebMarkupContainer("contyC");
        contyC.setOutputMarkupId(true);
        add(contyC);
        Label h13=new Label("h13","Header 13");
        contyC.add(h13);
        Label c13=new Label("c13","Content 13");
        contyC.add(c13);
        add(contyC);

        if(!isGeoVisible){
            geoC.setVisible(false);
        }
        if(!isPropTypesVisible){
            proptypeC.setVisible(false);
        }
        if(!isContactsVisible){
            contactC.setVisible(false);
        }
        if(!isOwnerShipVisible){
            ownershipC.setVisible(false);
        }
        if(!isCountyVisible){
            contyC.setVisible(false);
        }
    }
}
