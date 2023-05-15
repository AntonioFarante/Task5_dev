package ClassesForSqlQuery;

import java.math.BigDecimal;

public class ProjectPrices {
    private String name;
    private BigDecimal project_price;

    public ProjectPrices(String name, BigDecimal price_project) {
        this.name = name;
        this.project_price = price_project;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "name='" + name + '\'' +
                ", price_project " + project_price + " USD" +
                '}';
    }
}
