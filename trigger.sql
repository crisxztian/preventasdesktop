delimiter //
create trigger sumtotal after insert on detallepedido
for each row
begin
declare precio int;
declare total int;
select pedidos.total into total from pedidos,detallepedido where pedidos.id=new.pedidos_id and detallepedido.id=new.id;
select productos.precio into precio from productos,detallepedido where productos.id=new.productos_id and detallepedido.id=new.id;
update pedidos set total=total + (new.cantidad*precio) where pedidos.id=new.pedidos_id;
end;//


