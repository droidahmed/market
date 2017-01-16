package degree.nano.ahmed.nanodegree.model;

/**
 * Created by sand on 16/01/17.
 */
public class CategoryModel {

    String name;
    String id;
    String urlPath;

    public CategoryModel(String name, String id,String urlPath) {
        this.name = name;
        this.id = id;
        this.urlPath = urlPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
