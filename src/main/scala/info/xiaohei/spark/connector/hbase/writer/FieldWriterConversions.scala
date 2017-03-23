package info.xiaohei.spark.connector.hbase.writer

import org.apache.hadoop.hbase.util.Bytes

/**
  * Created by xiaohei on 2017/3/20.
  */
trait FieldWriterConversions extends Serializable{
  implicit def intWriter: FieldWriter[Int] = new SingleColumnFieldWriter[Int] {
    override def mapSingleColumn(data: Int): Option[Array[Byte]] = Some(Bytes.toBytes(data))
  }

  implicit def longWriter: FieldWriter[Long] = new SingleColumnFieldWriter[Long] {
    override def mapSingleColumn(data: Long): Option[Array[Byte]] = Some(Bytes.toBytes(data))
  }

  implicit def shortWriter: FieldWriter[Short] = new SingleColumnFieldWriter[Short] {
    override def mapSingleColumn(data: Short): Option[Array[Byte]] = Some(Bytes.toBytes(data))
  }

  implicit def doubleWriter: FieldWriter[Double] = new SingleColumnFieldWriter[Double] {
    override def mapSingleColumn(data: Double): Option[Array[Byte]] = Some(Bytes.toBytes(data))
  }

  implicit def floatWriter: FieldWriter[Float] = new SingleColumnFieldWriter[Float] {
    override def mapSingleColumn(data: Float): Option[Array[Byte]] = Some(Bytes.toBytes(data))
  }

  implicit def booleanWriter: FieldWriter[Boolean] = new SingleColumnFieldWriter[Boolean] {
    override def mapSingleColumn(data: Boolean): Option[Array[Byte]] = Some(Bytes.toBytes(data))
  }

  implicit def bigDecimalWriter: FieldWriter[BigDecimal] = new SingleColumnFieldWriter[BigDecimal] {
    override def mapSingleColumn(data: BigDecimal): Option[Array[Byte]] = Some(Bytes.toBytes(data.bigDecimal))
  }

  implicit def stringWriter: FieldWriter[String] = new SingleColumnFieldWriter[String] {
    override def mapSingleColumn(data: String): Option[Array[Byte]] = Some(Bytes.toBytes(data))
  }

  // Options

  implicit def optionWriter[T](implicit c: FieldWriter[T]): FieldWriter[Option[T]] = new FieldWriter[Option[T]] {
    override def convertHBaseData(data: Option[T]): HBaseData = if(data.nonEmpty) c.convertHBaseData(data.get) else Seq(None)
  }

  // Tuples


  implicit def tupleWriter2[T1, T2](implicit c1: FieldWriter[T1], c2: FieldWriter[T2]): FieldWriter[(T1, T2)] = new FieldWriter[(T1, T2)] {
    override def convertHBaseData(data: (T1, T2)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2)
  }

  implicit def tupleWriter3[T1, T2, T3](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3]): FieldWriter[(T1, T2, T3)] = new FieldWriter[(T1, T2, T3)] {
    override def convertHBaseData(data: (T1, T2, T3)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3)
  }

  implicit def tupleWriter4[T1, T2, T3, T4](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4]): FieldWriter[(T1, T2, T3, T4)] = new FieldWriter[(T1, T2, T3, T4)] {
    override def convertHBaseData(data: (T1, T2, T3, T4)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4)
  }

  implicit def tupleWriter5[T1, T2, T3, T4, T5](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5]): FieldWriter[(T1, T2, T3, T4, T5)] = new FieldWriter[(T1, T2, T3, T4, T5)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5)
  }

  implicit def tupleWriter6[T1, T2, T3, T4, T5, T6](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6]): FieldWriter[(T1, T2, T3, T4, T5, T6)] = new FieldWriter[(T1, T2, T3, T4, T5, T6)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6)
  }

  implicit def tupleWriter7[T1, T2, T3, T4, T5, T6, T7](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7)
  }

  implicit def tupleWriter8[T1, T2, T3, T4, T5, T6, T7, T8](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8)
  }

  implicit def tupleWriter9[T1, T2, T3, T4, T5, T6, T7, T8, T9](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9)
  }

  implicit def tupleWriter10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10)
  }

  implicit def tupleWriter11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11)
  }

  implicit def tupleWriter12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12)
  }

  implicit def tupleWriter13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13)
  }

  implicit def tupleWriter14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14)
  }

  implicit def tupleWriter15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14], c15: FieldWriter[T15]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14) ++ c15.convertHBaseData(data._15)
  }

  implicit def tupleWriter16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14], c15: FieldWriter[T15], c16: FieldWriter[T16]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14) ++ c15.convertHBaseData(data._15) ++ c16.convertHBaseData(data._16)
  }

  implicit def tupleWriter17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14], c15: FieldWriter[T15], c16: FieldWriter[T16], c17: FieldWriter[T17]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14) ++ c15.convertHBaseData(data._15) ++ c16.convertHBaseData(data._16) ++ c17.convertHBaseData(data._17)
  }

  implicit def tupleWriter18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14], c15: FieldWriter[T15], c16: FieldWriter[T16], c17: FieldWriter[T17], c18: FieldWriter[T18]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14) ++ c15.convertHBaseData(data._15) ++ c16.convertHBaseData(data._16) ++ c17.convertHBaseData(data._17) ++ c18.convertHBaseData(data._18)
  }

  implicit def tupleWriter19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14], c15: FieldWriter[T15], c16: FieldWriter[T16], c17: FieldWriter[T17], c18: FieldWriter[T18], c19: FieldWriter[T19]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14) ++ c15.convertHBaseData(data._15) ++ c16.convertHBaseData(data._16) ++ c17.convertHBaseData(data._17) ++ c18.convertHBaseData(data._18) ++ c19.convertHBaseData(data._19)
  }

  implicit def tupleWriter20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14], c15: FieldWriter[T15], c16: FieldWriter[T16], c17: FieldWriter[T17], c18: FieldWriter[T18], c19: FieldWriter[T19], c20: FieldWriter[T20]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14) ++ c15.convertHBaseData(data._15) ++ c16.convertHBaseData(data._16) ++ c17.convertHBaseData(data._17) ++ c18.convertHBaseData(data._18) ++ c19.convertHBaseData(data._19) ++ c20.convertHBaseData(data._20)
  }

  implicit def tupleWriter21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14], c15: FieldWriter[T15], c16: FieldWriter[T16], c17: FieldWriter[T17], c18: FieldWriter[T18], c19: FieldWriter[T19], c20: FieldWriter[T20], c21: FieldWriter[T21]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14) ++ c15.convertHBaseData(data._15) ++ c16.convertHBaseData(data._16) ++ c17.convertHBaseData(data._17) ++ c18.convertHBaseData(data._18) ++ c19.convertHBaseData(data._19) ++ c20.convertHBaseData(data._20) ++ c21.convertHBaseData(data._21)
  }

  implicit def tupleWriter22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22](implicit c1: FieldWriter[T1], c2: FieldWriter[T2], c3: FieldWriter[T3], c4: FieldWriter[T4], c5: FieldWriter[T5], c6: FieldWriter[T6], c7: FieldWriter[T7], c8: FieldWriter[T8], c9: FieldWriter[T9], c10: FieldWriter[T10], c11: FieldWriter[T11], c12: FieldWriter[T12], c13: FieldWriter[T13], c14: FieldWriter[T14], c15: FieldWriter[T15], c16: FieldWriter[T16], c17: FieldWriter[T17], c18: FieldWriter[T18], c19: FieldWriter[T19], c20: FieldWriter[T20], c21: FieldWriter[T21], c22: FieldWriter[T22]): FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)] = new FieldWriter[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)] {
    override def convertHBaseData(data: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22)): HBaseData = c1.convertHBaseData(data._1) ++ c2.convertHBaseData(data._2) ++ c3.convertHBaseData(data._3) ++ c4.convertHBaseData(data._4) ++ c5.convertHBaseData(data._5) ++ c6.convertHBaseData(data._6) ++ c7.convertHBaseData(data._7) ++ c8.convertHBaseData(data._8) ++ c9.convertHBaseData(data._9) ++ c10.convertHBaseData(data._10) ++ c11.convertHBaseData(data._11) ++ c12.convertHBaseData(data._12) ++ c13.convertHBaseData(data._13) ++ c14.convertHBaseData(data._14) ++ c15.convertHBaseData(data._15) ++ c16.convertHBaseData(data._16) ++ c17.convertHBaseData(data._17) ++ c18.convertHBaseData(data._18) ++ c19.convertHBaseData(data._19) ++ c20.convertHBaseData(data._20) ++ c21.convertHBaseData(data._21) ++ c22.convertHBaseData(data._22)
  }

}
