package com.ak.testtask.repositories;

import com.ak.testtask.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {

    //todo use as named query
    @Query(nativeQuery = true,
            value = "SELECT id,\n" +
                    "       symbol,\n" +
                    "       company_name,\n" +
                    "       primary_exchange,\n" +
                    "       calculation_price,\n" +
                    "       open,\n" +
                    "       open_time,\n" +
                    "       open_source,\n" +
                    "       close,\n" +
                    "       close_time,\n" +
                    "       close_source,\n" +
                    "       high,\n" +
                    "       high_time,\n" +
                    "       high_source,\n" +
                    "       low,\n" +
                    "       low_time,\n" +
                    "       low_source,\n" +
                    "       latest_price,\n" +
                    "       latest_source,\n" +
                    "       latest_time,\n" +
                    "       latest_update,\n" +
                    "       latest_volume,\n" +
                    "       iex_realtime_price,\n" +
                    "       iex_realtime_size,\n" +
                    "       iex_last_updated,\n" +
                    "       delayed_price,\n" +
                    "       delayed_price_time,\n" +
                    "       odd_lot_delayed_price,\n" +
                    "       odd_lot_delayed_price_time,\n" +
                    "       extended_price,\n" +
                    "       extended_change,\n" +
                    "       extended_change_percent,\n" +
                    "       extended_price_time,\n" +
                    "       previous_close,\n" +
                    "       previous_volume,\n" +
                    "       change,\n" +
                    "       change_percent,\n" +
                    "       volume,\n" +
                    "       iex_market_percent,\n" +
                    "       iex_volume,\n" +
                    "       avg_total_volume,\n" +
                    "       iex_bid_price,\n" +
                    "       iex_bid_size,\n" +
                    "       iex_ask_price,\n" +
                    "       iex_ask_size,\n" +
                    "       iex_open,\n" +
                    "       iex_open_time,\n" +
                    "       iex_close,\n" +
                    "       iex_close_time,\n" +
                    "       market_cap,\n" +
                    "       pe_ratio,\n" +
                    "       week_52_high,\n" +
                    "       week_52_low,\n" +
                    "       ytd_change,\n" +
                    "       last_trade_time,\n" +
                    "       is_us_market_open\n" +
                    "FROM (\n" +
                    "         SELECT *,\n" +
                    "                row_number()\n" +
                    "                OVER (PARTITION BY company_name order by latest_update DESC ) as last_updated_value\n" +
                    "         FROM symbols\n" +
                    "     ) as result\n" +
                    "WHERE last_updated_value = 1\n" +
                    "ORDER BY COALESCE(previous_volume, volume) DESC, company_name\n" +
                    "LIMIT 5;")
    List<Symbol> findTopHighestValueStocks();


    @Query(nativeQuery = true,
            value = "WITH companies_by_last_update_with_income AS (\n" +
            "    WITH curr_prev_price_by_latest_update AS\n" +
            "             (SELECT *,\n" +
            "                     row_number()\n" +
            "                     OVER (PARTITION BY company_name order by latest_update DESC ) as updated_row,\n" +
            "                     lead(latest_price, 1)\n" +
            "                     OVER (PARTITION BY company_name order by latest_update DESC)  as prev_price\n" +
            "              FROM symbols\n" +
            "             )\n" +
            "    SELECT *,\n" +
            "           latest_price / prev_price as income\n" +
            "    FROM curr_prev_price_by_latest_update\n" +
            "    WHERE updated_row = 1\n" +
            ")\n" +
            "SELECT id,\n" +
            "       symbol,\n" +
            "       company_name,\n" +
            "       primary_exchange,\n" +
            "       calculation_price,\n" +
            "       open,\n" +
            "       open_time,\n" +
            "       open_source,\n" +
            "       close,\n" +
            "       close_time,\n" +
            "       high,\n" +
            "       high_time,\n" +
            "       high_source,\n" +
            "       low,\n" +
            "       low_time,\n" +
            "       low_source,\n" +
            "       latest_price,\n" +
            "       latest_source,\n" +
            "       latest_time,\n" +
            "       latest_update,\n" +
            "       latest_volume,\n" +
            "       iex_realtime_price,\n" +
            "       iex_realtime_size,\n" +
            "       iex_last_updated,\n" +
            "       delayed_price,\n" +
            "       delayed_price_time,\n" +
            "       odd_lot_delayed_price,\n" +
            "       odd_lot_delayed_price_time,\n" +
            "       extended_price,\n" +
            "       extended_change,\n" +
            "       extended_change_percent,\n" +
            "       extended_price_time,\n" +
            "       previous_close,\n" +
            "       previous_volume,\n" +
            "       change,\n" +
            "       change_percent,\n" +
            "       volume,\n" +
            "       iex_market_percent,\n" +
            "       iex_volume,\n" +
            "       avg_total_volume,\n" +
            "       iex_bid_price,\n" +
            "       iex_bid_size,\n" +
            "       iex_ask_price,\n" +
            "       iex_ask_size,\n" +
            "       iex_open,\n" +
            "       iex_open_time,\n" +
            "       iex_close,\n" +
            "       iex_close_time,\n" +
            "       market_cap,\n" +
            "       pe_ratio,\n" +
            "       week_52_high,\n" +
            "       week_52_low,\n" +
            "       ytd_change,\n" +
            "       last_trade_time,\n" +
            "       is_us_market_open\n" +
            "FROM companies_by_last_update_with_income\n" +
            "ORDER BY income DESC\n" +
            "LIMIT 5;")
    List<Symbol> findTopRecentWithGreatestIncome();
}
