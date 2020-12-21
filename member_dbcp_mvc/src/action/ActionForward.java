package action;
//어디로 갈것인지. 어떤방식으로갈것인지

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActionForward {
	private String path;
	private boolean redirect;
}
