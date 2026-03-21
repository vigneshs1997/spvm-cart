# spvm-cart
E-COMMERCE

## 📦 Products (Public)

| Method | Endpoint                  | Description                          |
|--------|--------------------------|--------------------------------------|
| GET    | /products                | List all products                    |
| GET    | /products/:id            | View a specific product              |
| GET    | /products/search?...     | Search, filter, and paginate products|

## 📥 Input Parameters

- **category**: Product category to filter (e.g., "Phones")
- **minPrice, maxPrice**: Price range boundaries
- **rating**: Minimum acceptable product rating
- **keyword**: Search term for name or description  

## ⚙️ Specification Composition

Uses **Spring Data JPA Specifications** for flexible query building.

- **hasCategory(category)** — Matches exact category
- **priceBetween(minPrice, maxPrice)** — Filters by price range
- **ratingGreaterThan(rating)** — Ensures rating threshold
- **searchKeyword(keyword)** — Performs keyword-based search  