package com.product.practice;

import org.apache.wicket.ajax.AjaxEventBehavior;

/**
 * Created by Kamlesh on 2015-07-19.
 */
public abstract class OnClickEventBehavior extends AjaxEventBehavior {
    public OnClickEventBehavior() {
        super("onclick");
    }
}
