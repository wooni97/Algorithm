-- 코드를 입력하세요
select a.category, sum(b.sales) as total_sales
from book as a, book_sales as b
where a.book_id = b.book_id
and b.sales_date between '2022-01-01' and '2022-01-31'
group by a.category
order by a.category
;