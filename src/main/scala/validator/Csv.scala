package validator

type Column = String
def Column(column: String): Column = column

type Row = Seq[Column]
def Row(columns: Column*): Seq[Column] = Seq(columns: _*)

type Rows = Seq[Row]
def Rows(rows: Row*): Seq[Row] = Seq(rows: _*)

final case class Csv(rows: Rows)