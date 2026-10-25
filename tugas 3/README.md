# Hari 15 — Selenium Locator Practice

Proyek ini berisi aplikasi web lokal dan tiga test suite untuk mempelajari locator Selenium.

## Prasyarat

- JDK 17 atau lebih baru
- Maven 3.9 atau lebih baru
- Google Chrome atau Chromium

ChromeDriver dikelola otomatis oleh Selenium Manager.

## Menjalankan pengujian

Dari direktori `source`, jalankan:

```bash
mvn clean test
```

Contoh pada Windows:

```bat
cd d:\JuaraCoding\bootcamp\java-sqa\hari-15\source
mvn clean test
```

Browser dijalankan dalam mode headless. Jika Chrome tidak terpasang di lokasi standar, lokasinya dapat diberikan melalui `-Dchrome.binary` atau environment variable `CHROME_BINARY`.

## Cakupan

- `BasicEightLocatorsTest`: ID, name, class name, tag name, link text, partial link text, CSS Selector, dan XPath.
- `AdvancedCssSelectorTest`: substring matchers, direct child, adjacent sibling, dan pseudo-classes.
- `DynamicXPathAxesTest`: teks dinamis, kondisi boolean, `following-sibling`, dan `ancestor`.

Total: 16 pengujian.
