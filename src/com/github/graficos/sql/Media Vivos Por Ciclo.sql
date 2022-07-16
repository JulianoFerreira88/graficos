select 
p.CICLO as CICLO, 
avg( 
    cast(p.NUVIVO as numeric(15,2))
) as MEDIA_VIVOS 
from esanparto p 
group by CICLO

