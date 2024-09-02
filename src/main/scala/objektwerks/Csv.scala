package objektwerks

type Column = String
def Column(column: String): Column = column

type Row = Seq[Column]
def Row(columns: Column*): Seq[Column] = Seq(columns*)

type Rows = Seq[Row]
def Rows(rows: Row*): Seq[Row] = Seq(rows*)

final case class Csv(rows: Rows)