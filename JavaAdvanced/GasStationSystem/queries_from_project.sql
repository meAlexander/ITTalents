SELECT * FROM gas_station.station_loadings;

SELECT kolonka_id, fuel_type, fuel_quantity, loading_time
FROM station_loadings
ORDER BY kolonka_id, loading_time ASC;

SELECT kolonka_id, COUNT(order_id) as car_quantity
FROM station_loadings
GROUP BY kolonka_id
ORDER BY kolonka_id;

SELECT fuel_type, SUM(fuel_quantity) as fuel_quantity
FROM station_loadings
GROUP BY fuel_type;

SELECT fuel_type, SUM(fuel_quantity), SUM(fuel_quantity) as fuel_quantity,
CASE fuel_type WHEN "petrol" THEN SUM(fuel_quantity) * 2.40
						  WHEN "gas" THEN SUM(fuel_quantity) * 1.60
                          ELSE SUM(fuel_quantity) * 2
                          END AS price
FROM station_loadings
GROUP BY fuel_type;