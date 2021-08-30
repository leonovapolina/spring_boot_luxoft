package com.luxoft.training.springboot.dao;

import com.luxoft.training.springboot.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryDao {
    private static final CountryRowMapper COUNTRY_ROW_MAPPER = new CountryRowMapper();

    @Autowired
    private NamedParameterJdbcTemplate namedJdbc;

    public List<Country> getCountryList() {
        return namedJdbc.getJdbcTemplate().query("select * from country", COUNTRY_ROW_MAPPER);
    }

    public List<Country> getCountryListStartWith(String name) {
        return namedJdbc.query(
                "select * from country where name like :name",
                new MapSqlParameterSource("name", name + "%"),
                COUNTRY_ROW_MAPPER);
    }

    public void updateCountryName(String codeName, String newCountryName) {
        namedJdbc.update("update country SET name = :newCountryName where code_name = :codeName",
                new MapSqlParameterSource()
                        .addValue("newCountryName", newCountryName)
                        .addValue("codeName", codeName));
    }

    public Country getCountryByCodeName(String codeName) {
        return namedJdbc.query(
                "select * from country where code_name = :codeName",
                new MapSqlParameterSource("codeName", codeName),
                COUNTRY_ROW_MAPPER).get(0);
    }

    public Country getCountryByName(String name)
            throws CountryNotFoundException {
        List<Country> countryList = namedJdbc.query(
                "select * from country where name = :name",
                new MapSqlParameterSource("name", name),
                COUNTRY_ROW_MAPPER);
        if (countryList.isEmpty()) {
            throw new CountryNotFoundException();
        }
        return countryList.get(0);
    }
}

