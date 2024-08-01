-- 코드를 작성해주세요
with MaxSizes as (
    select max(size_of_colony) as MAX_SIZE, YEAR(differentiation_date) as year
    from ecoli_data
    group by YEAR(differentiation_date)
)
select m.year, (m.MAX_SIZE - a.SIZE_OF_COLONY) as year_dev, a.id
from ecoli_data as a, MaxSizes as m
where YEAR(a.DIFFERENTIATION_DATE) = m.year
order by m.year asc, year_dev asc
;