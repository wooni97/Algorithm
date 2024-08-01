-- 코드를 작성해주세요
select a.id, b.fish_name, a.length
from fish_info as a, fish_name_info as b, (select fish_type, max(length) as length
                                            from fish_info
                                            group by fish_type) as c
where a.fish_type = b.fish_type and a.fish_type = c.fish_type and a.length = c.length
;

