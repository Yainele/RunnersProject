package com.boots.event.race;

public enum RaceStatus {WAITING_TO_START,AWAITS_EXECUTION ,NOT_FINISHED, FINISHED, CANCELED, MODERATED}
/*
 Создал забег - статус ожидает выполнения AWAITS_EXECUTION
 Пробежал - отправил на модерацию: статус модерации (время, км) MODERATED
 не начал забег к выбранному времени: статус в подвешенном состоянии IN_LIMBO
 прошел модерацию - статус: завершен, отклонен  FINISHED CANCELED
 не удачная попытка - не финиширофал NOT_FINISHED
 */
