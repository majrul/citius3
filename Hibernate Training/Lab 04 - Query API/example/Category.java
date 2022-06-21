package example;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private int id;
	private String name;
	private Category parentCategory;
	private Set childCategories;
	private Set items;
	
	public void addChildCategory(Category childCategory) {
		if(childCategory.getParentCategory() != null)
			childCategory.getParentCategory().getChildCategories().remove(childCategory);
		childCategory.setParentCategory(this);
		getChildCategories().add(childCategory);
	}
	
	public void addItem(Item item) {
		getItems().add(item);
		item.getCategories().add(this);
	}

	public Set getItems() {
		return items == null ? new HashSet() : items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

	public Set getChildCategories() {
		return childCategories == null ?  new HashSet() : childCategories;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setChildCategories(Set childCategories) {
		this.childCategories = childCategories;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "<===Category ID = " + id + " , Name = " + name + "===>";
	}
}
