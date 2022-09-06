package Service;

import DAO.categoryRepository;

public class categoryService {

    categoryRepository cr;
    public categoryService()
    {
        cr = new categoryRepository();
    }
    public int getCategoryIDFromName(String name)
    {
        return cr.getCategoryIDFromName(name);
    }
}
