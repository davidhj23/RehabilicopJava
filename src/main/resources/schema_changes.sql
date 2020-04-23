USE rehabilicop;
ALTER TABLE antecedente DROP FOREIGN KEY FK7rcc74x1dq1kg65oc1qkscs19;
ALTER TABLE antecedente DROP COLUMN id_es_la_primera_hospitalizacion;
ALTER TABLE antecedente ADD COLUMN causa VARCHAR(255);

ALTER TABLE farmacologico DROP FOREIGN KEY FKkcm18900vo851wxv93nv48h5o;
ALTER TABLE farmacologico DROP COLUMN id_tiempo_de_uso;
ALTER TABLE farmacologico ADD COLUMN tiempo_de_uso VARCHAR(255);

ALTER TABLE farmacologico DROP FOREIGN KEY FK3kq3r2wsqgwq49ue3jww4g77w;
ALTER TABLE farmacologico DROP COLUMN id_adverso;
ALTER TABLE farmacologico ADD COLUMN evento_adverso VARCHAR(255);

UPDATE gineco_obstetricio SET partos = '';

ALTER TABLE historia ADD COLUMN id_impresion_diagnostica2 binary(255);
ALTER TABLE historia ADD COLUMN id_impresion_diagnostica3 binary(255);




