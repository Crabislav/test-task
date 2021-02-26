WITH companies_by_last_update_with_income AS (
    WITH curr_prev_price_by_latest_update AS (
        SELECT *,
               row_number()
               OVER (PARTITION BY company_name order by latest_update DESC ) as updated_row,
               lead(latest_price, 1)
               OVER (PARTITION BY company_name order by latest_update DESC)  as prev_price
        FROM symbols
    )
    SELECT *,
           latest_price / prev_price as income
    FROM curr_prev_price_by_latest_update
    WHERE updated_row = 1
)
SELECT id,
       symbol,
       company_name,
       primary_exchange,
       calculation_price,
       open,
       open_time,
       open_source,
       close,
       close_time,
       high,
       high_time,
       high_source,
       low,
       low_time,
       low_source,
       latest_price,
       latest_source,
       latest_time,
       latest_update,
       latest_volume,
       iex_realtime_price,
       iex_realtime_size,
       iex_last_updated,
       delayed_price,
       delayed_price_time,
       odd_lot_delayed_price,
       odd_lot_delayed_price_time,
       extended_price,
       extended_change,
       extended_change_percent,
       extended_price_time,
       previous_close,
       previous_volume,
       change,
       change_percent,
       volume,
       iex_market_percent,
       iex_volume,
       avg_total_volume,
       iex_bid_price,
       iex_bid_size,
       iex_ask_price,
       iex_ask_size,
       iex_open,
       iex_open_time,
       iex_close,
       iex_close_time,
       market_cap,
       pe_ratio,
       week_52_high,
       week_52_low,
       ytd_change,
       last_trade_time,
       is_us_market_open
FROM companies_by_last_update_with_income
ORDER BY income DESC
LIMIT 5;