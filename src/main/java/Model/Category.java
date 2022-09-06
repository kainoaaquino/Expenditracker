package Model;

public class Category {
    public int cat_id;
    public String name;

    public Category(int cat_id, String name)
    {
        this.cat_id = cat_id;
        this.name = name;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cat_id=" + cat_id +
                ", name='" + name + '\'' +
                '}';
    }
}
