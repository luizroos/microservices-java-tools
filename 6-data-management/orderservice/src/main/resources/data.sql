DROP TABLE IF EXISTS tbl_order_line;
DROP TABLE IF EXISTS tbl_order;

CREATE TABLE tbl_order (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  status VARCHAR(250) NOT NULL,
  total_order DOUBLE DEFAULT NULL
);

CREATE TABLE tbl_order_line (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  quantity INT DEFAULT NULL,
  product_id INT DEFAULT NULL,
  order_id INT DEFAULT NULL
);

INSERT INTO tbl_order (status, total_order) VALUES
  ('CLOSED', 50.00),
  ('OPEN', 70.00);

INSERT INTO tbl_order_line (quantity, product_id, order_id) VALUES
  (1, 1, 1),
  (2, 2, 1),
  (3, 1, 2),
  (4, 1, 2);