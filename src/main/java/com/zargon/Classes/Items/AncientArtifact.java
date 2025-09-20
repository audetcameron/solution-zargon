package com.zargon.Classes.Items;

import com.zargon.Classes.Item;

public class AncientArtifact extends Item {




    public AncientArtifact(String name, int qty, int value , String description) {
        super(name, qty, value);
        this.setDescription(description);
        this.type = "misc"; // Set the type to "misc" for miscellaneous items
    }


    
}
