package action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActionForward {
	private String path; //어디로 갈것인가
	private boolean redirect; //어떤 방식으로 갈것인가 ture면 redirect, false면 foward
	//블린은 getter 가 is로 만들어진다.
	
}
