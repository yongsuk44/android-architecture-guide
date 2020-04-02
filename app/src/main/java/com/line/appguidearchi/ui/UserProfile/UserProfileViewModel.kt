package com.line.appguidearchi.ui.UserProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.line.appguidearchi.data.db.entity.User

/**
 * UserProfileFragment에서 볼 수 있도록 데이터를 준비, 사용자 상호작용에 반응
 *
 * user 필드가 설정되면 UI에 알려야하는데 user를 가져오려면 ViewModel에서 fragment 인수에 access해야 한다.
 * fragment에서 인수를 전달할 수도 있고, 더 나은 방법으로 SavedState Module을 사용해 Viewmodel에서 직접 인수를 읽도록 할 수 있다.
 */
class UserProfileViewModel(repository: UserRepository) : ViewModel() {
    val userID : String = "User ID"
    val userObject : LiveData<User> = repository.getUser(userID)
}