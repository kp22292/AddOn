package com.oxos.google.addons.model.navigation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.api.client.util.Lists;
import com.oxos.google.addons.model.action.OnClick;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Data
@Builder
@JsonInclude( JsonInclude.Include.NON_EMPTY )
@JsonTypeName("openLink")
public class OpenLink {
  private String url;
  private OpenLink.onClose onClose;
  private OpenLink.openAs openAs;
  public enum onClose {
    NOTHING,
    RELOAD
  }
  public enum openAs {
    FULL_SIZE,
    OVERLAY
  }
}
