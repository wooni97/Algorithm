-- 코드를 입력하세요
select a.author_id, a.author_name, b.category, sum((s.sales * b.price)) as total_sales
from book as b, author as a, book_sales as s
where b.author_id = a.author_id
and b.book_id = s.book_id
and s.sales_date between '2022-01-01' and '2022-01-31'
group by b.author_id, b.category
order by b.author_id, b.category desc
;

