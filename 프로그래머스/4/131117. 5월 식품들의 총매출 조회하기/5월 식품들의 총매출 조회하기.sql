-- 코드를 입력하세요

SELECT o.product_id, p.product_name, sum(o.amount) * p.price as total_sales
from food_order o, food_product as p
where o.product_id = p.product_id
and o.produce_date between '2022-05-1' and '2022-05-31'
group by o.product_id
order by total_sales desc,
         o.product_id asc
;
