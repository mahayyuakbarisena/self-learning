<?php

use Illuminate\Support\Facades\Route;
use App\Post;
use App\User;
use App\Role;
use App\Country;
use App\Photo;
use App\Tag;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
//     return view('welcome');
// });

// Route::get('/about', function () {
//     return "This is about page";
// });

// Route::get('/contact', function () {
//     return "My number : 082134797155";
// });

// Route::get('/post/{id}/{name}', function($id, $name){
//     return "This is post number ". $id. " created by ". $name;
// });

// Route::get('admin/posts/example', array('as' => 'admin.home', function(){
//     $url = route('admin.home');
    
//     return "this url is ". $url;
// }));

// Route::get('/post/{id}', 'PostsController@index');

// Route::resource('posts', 'PostsController');

// Route::get('/contact', 'PostsController@contact');

// Route::get('post/{id}/{name}/{class}', 'PostsController@showPost');

// ================
// Raw SQL Query ||
// ================

// Route::get('/insert', function(){
//     DB::insert('insert into posts(title, content) values (?,?)',['Laravel is Good', 'Hehe Boii']);
// });

// Route::get('/read', function(){
//     $results = DB::select('select * from posts where id = ?', [1]);
//     foreach ($results as $post){
//         return $post->title;
//     }
//     // return var_dump($results);
// });

// Route::get('/update', function(){
//     $updated = DB::update('update posts set title = "This is updated title" where id = ?', [1]);
//     return $updated;
// });

// Route::get('/delete', function(){
//     $deleted = DB::delete('delete from posts where id = ?', [1]);
//     if ($deleted){
//         return "deleted";
//     } else {
//         return "no data";
//     }
    
// });

// ================
// Eloquent      ||
// ================

// Route::get('/read', function(){
//     $posts = Post::all();
//     foreach($posts as $post){
//         return $post->title;
//     }
// });

// Route::get('/find', function(){
//     $posts = Post::find(2);
//     return $posts->title;
// });

// Route::get('/findwhere', function(){
//     $posts = Post::where('id', 3)->orderBy('id', 'desc')->take(1)->get();
//     return $posts;
// });

// Route::get('/findmore', function(){
//     $posts = Post::findOrFail(2);
//     return $posts;
//     $posts = Post::where('users_count','<', 50)->firstOrFail();
// });

// Route::get('/basicinsert',function(){
//     // $post = new Post;
//     // $post->title = 'New Title is here bois';
//     // $post->content = "Yeaaaaa Boiii";
//     // $post->save();

//     $post = Post::find(2);
//     $post->title = 'Edit data trial';
//     $post->content = "Data changed";
//     $post->save();
// });

Route::get('/create/{id}', function($id){
    Post::create(['title' => 'the create method'. $id , 'content' => 'I\'m learning this from Edwin Diaz' . $id, 'user_id' => $id]);
});

Route::get('/register/{name}/{email}/{password}/{country_id}', function($name, $email, $password, $country_id){
    User::create(['name' => $name , 'email' => $email, 'password' => $password, 'country_id' => $country_id]);
});

Route::get('/createRoles/{name}', function($name){
    Role::create(['name' => $name]);
});

//===================================ON PROGRESS=================================
// Route::get('/registerRoles/{user_id}/{role_id}', function($user_id, $role_id){
//     User::create(['user_id' => $user_id, 'role_id'=>$role_id]);
// });
//================================================================================

// Route::get('/update', function(){
//     Post::where('id', 2)->where('is_admin', 0)->update(['title'=>'Edited title', 'content' => 'Edited content']);
// });

// Route::get('/delete', function(){
//     $post = Post::find(2);
//     $post->delete();
// });

// Route::get('/delete2', function(){
//     Post::destroy(3);
// });

// Route::get('/delete2', function(){
//     Post::destroy([4,5]);
//     // Post::where('is_admin',0)->delete();
// });

Route::get('/softdelete', function(){
    Post::find(7)->delete();
});

// Route::get('/readsoftdelete', function(){
//     // $post = Post::find(1);
//     // return $post;

//     // $post = Post::withTrashed()->where('id', 1)->get();
//     // return $post;

//     $post = Post::onlyTrashed(0)->get();
//     return $post;
// });

// Route::get('/restore', function(){
//     Post::withTrashed()->restore();
// });

Route::get('/forcedelete', function(){
    Post::onlyTrashed()->forceDelete();
});

// ==============================
// Eloquent Relationships      ||
// ==============================

// One-to-One Relationship
Route::get('/user/{id}/post', function($id){
    return User::find($id)->post->content;
});

Route::get('/post/{id}/user', function($id){
    return Post::find($id)->user->name;
});

// One-to-Many Relationship
Route::get('/posts', function(){
    $user = User::find(1);
    foreach($user->posts as $post){
        echo $post->title . "<br>";
    }
});

// Many-to-Many Relationship
Route::get('/user/{id}/role', function($id){
    $user = User::find($id)->roles()->get();
    return $user;
    // foreach($user as $test){
    //     return $test->name;
    // };
});

//Accessing the intermediate table / pivot table
Route::get('user/pivot', function(){
    $user = User::find(1);
    foreach($user->roles as $role){
        echo $role->pivot->created_at;
    } 
});

Route::get('/user/country/{country_id}', function($country_id){
    $country = Country::find($country_id);
    foreach($country->posts as $post){
        echo $post->title . "<br>";
    };
});

// =================================
// Polymorphic Relationships      ||
// =================================
Route::get('user/photos', function(){
    $user = User::find(1);
    foreach($user->photos as $photo){
        return $photo->path;
    };
});

Route::get('post/{id}/photos', function($id){
    $post = Post::find($id);
    if ($post){
        foreach($post->photos as $photo){
            echo $photo->path . "<br>";
        }
    } else {
        echo "Not Found";
    }
    
});

Route::get('photo/{id}/post', function($id){
    $photo = Photo::findOrFail($id);
    return $photo->imageable;
});

// =================================
// Polymorphic Many to Many       ||
// =================================

Route::get('post/tag', function(){
    $post = Post::find(1);
    echo 'Post "' . $post->title . '" is tagged by: <br>';
    foreach($post->tags as $tag){
        echo $tag->name . '<br>';
    };
});

Route::get('tag/video',function(){
    $tag = Tag::find(1);
    foreach($tag->videos as $video){
        echo $video->name . '<br>';
    };
});