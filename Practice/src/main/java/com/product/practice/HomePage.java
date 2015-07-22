package com.product.practice;

import com.google.common.collect.Lists;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;


import java.util.*;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private static final int COLUMNS_PER_ROWS=5;
	private List<List<String>> rows=new ArrayList<List<String>>();
	List<String> columnNames=new ArrayList<String>();
	Collection<String> columns=new ArrayList<String>();
	List<String> defaultColumnNames=new ArrayList<String>();
	ListView<List<String>> columnNameRows;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		FilterClazz filterClazz=new FilterClazz();
		Map<String, List<String>> possibleColumnMap=new HashMap<String, List<String>>();
		Form<FilterClazz> form=new Form<FilterClazz>("filter-form");
		add(form);
		String moduleName="Property";
		final List<String> fieldsName=new ArrayList<String>();
		for(int i=1;i<10;i++){
			fieldsName.add("Field"+i);
		}

		for(int i=2;i<8;i++){
			defaultColumnNames.add("Field"+i);
		}


		possibleColumnMap.put(moduleName,defaultColumnNames);
		columnNames=getMapValues(possibleColumnMap);

		generateRows();
		setDefaultModel(new CompoundPropertyModel<FilterClazz>(filterClazz));
		final CheckGroup<String> columnNamesChoices=new CheckGroup<String>("choiceGroup");
		columnNamesChoices.setRenderBodyOnly(false);
		columnNameRows=new ListView<List<String>>("rowNames",rows) {
			@Override
			protected void populateItem(ListItem<List<String>> listItem) {
				final List<String> module=listItem.getModelObject();
				final ListView<String> columnNameCells=new ListView<String>("columnCells",module) {
					@Override
					protected void populateItem(ListItem<String> listItem) {
						final String cell=listItem.getModelObject();
						final Check check=new Check<String>("check",new Model<String>(cell));
						check.add(new OnClickEventBehavior() {
							@Override
							protected void onEvent(AjaxRequestTarget target) {
								if(columnNames.size()==1){
									columnNames.addAll(fieldsName);
								}
								else{
									if(fieldsName.contains(cell)) {
										columnNames.remove(cell);
									}
								}
								generateRows();
								columnNameRows.removeAll();
								target.add(columnNamesChoices);
							}
						});

						final Label label=new Label("label",cell.toString());
						listItem.add(check);
						listItem.add(label);
					}
				};
				columnNameCells.setReuseItems(true);
				listItem.add(columnNameCells);
			}
		};
		columnNamesChoices.add(columnNameRows).setOutputMarkupId(true);
		columnNameRows.setReuseItems(true).setOutputMarkupId(true);
		form.add(columnNamesChoices);


    }

	public void generateRows(){
		rows.clear();
		final int NO_OF_ROWS=(int)Math.ceil((double)columnNames.size() / (double)COLUMNS_PER_ROWS);
		for(int i=0;i<NO_OF_ROWS;i++){
			if(rows.size()==i) rows.add(Lists.<String>newArrayList());
			for(int j=0;j<COLUMNS_PER_ROWS;j++){
				final int index=i*COLUMNS_PER_ROWS+j;
				if(index<columnNames.size()){
					rows.get(i).add(columnNames.get(index));
				}
			}
		}

	}

	public List<String> getMapValues(Map<String,List<String>> possibleMap){

		List<String> columnNames=new ArrayList<String>();

		for(String key:possibleMap.keySet()){
			List<String> fieldsName=possibleMap.get(key);
			for(String str:fieldsName){
				columnNames.add(str);
			}
		}

		return columnNames;
	}


}
