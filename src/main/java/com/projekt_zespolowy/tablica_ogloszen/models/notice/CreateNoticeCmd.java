package com.projekt_zespolowy.tablica_ogloszen.models.notice;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.image.CreateImageCmd;
import com.projekt_zespolowy.tablica_ogloszen.models.notice.NoticeStatus.NOTICE_STATUS;
import com.projekt_zespolowy.tablica_ogloszen.models.price.CreatePriceCmd;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoticeCmd {

  private Long vendor;
  private String title;
  private String text;
  private CreatePriceCmd price;
  private List<CreateImageCmd> images = Lists.newArrayList();
  private LocalDateTime creationDate = LocalDateTime.now();
  private NoticeStatus status = NOTICE_STATUS.ACTIVE.toNoticeStatus();

}
