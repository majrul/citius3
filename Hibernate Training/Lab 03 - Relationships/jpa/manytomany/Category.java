package jpa.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="a_cats")
public class Category {

	@Id @GeneratedValue private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="parent_id",nullable=true)
	private Category parentCategory;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="parent_id")
	private Set<Category> childCategories;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="a_categories_items", 
			joinColumns={@JoinColumn(name="cat_id")},
			inverseJoinColumns={@JoinColumn(name="item_id")})
	private Set<Item> items;

	public Set<Item> getItems() {
		return items == null ? new HashSet<Item>() : items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Set<Category> getChildCategories() {
		return childCategories == null ?  new HashSet<Category>() : childCategories;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setChildCategories(Set<Category> childCategories) {
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
